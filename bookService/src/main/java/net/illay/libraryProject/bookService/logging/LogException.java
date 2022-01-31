package net.illay.libraryProject.bookService.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

@Aspect
@Component
public class LogException {

    @AfterThrowing(pointcut = "execution(* net.illay.libraryProject.bookService..*(..))", throwing = "e")
    public Object logException(JoinPoint point, Exception e) throws Throwable {
        var codeSignature = (CodeSignature) point.getSignature();
        var methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();

        Logger logger = LoggerFactory.getLogger(method.getDeclaringClass());
        LogLevel level = LogLevel.ERROR;
        boolean showArgs = true;
        String methodName = method.getName();
        Object[] methodArgs = point.getArgs();
        String[] methodParams = codeSignature.getParameterNames();

        var response = point.getKind();
        log(logger, level, message(methodName, showArgs, methodParams, methodArgs) + " with exception: " + e);
        return response;
    }

    static String message(String methodName, boolean showArgs, String[] params, Object[] args) {
        StringJoiner message = new StringJoiner(" ")
                .add("Exception in method:").add(methodName).add("method");

        if (showArgs && Objects.nonNull(params) && Objects.nonNull(args) && params.length == args.length) {
            Map<String, Object> values = new HashMap<>(params.length);

            for (int i = 0; i < params.length; i++) {
                values.put(params[i], args[i]);
            }
            message.add("with args:")
                    .add(values.toString());
        }
        return message.toString();
    }
    static void log(Logger logger, LogLevel level, String message) {
        logger.error(message);
    }
}