package com.tt.utils.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class SystemLogAspect {

//    @Autowired
//    private SysLogMapper systemlogMapper;

    @Pointcut("@annotation(com.tt.utils.annotation.SystemLog)")
    public void logPointCut() {}


}
