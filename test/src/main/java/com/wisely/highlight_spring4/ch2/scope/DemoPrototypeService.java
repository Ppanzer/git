package com.wisely.highlight_spring4.ch2.scope;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope;
/**
 * @author xjq
 * @date 2020/7/28
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {
}
