package com.wisely.highlight_spring4.ch3.conditional;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
/**
 * @author xjq
 * @date 2020/7/29
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata meatadata){
        return context.getEnvironment().getProperty("os.name").contains("Windows");
    }
}
