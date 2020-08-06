package web.project.backend.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
	
	
	@Around("execution(* web.project.backend..*(..)) && !target(web.project.backend.SpringConfig)\")") 
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		System.out.println("START: "+joinPoint.toShortString());
		
		try {
			return joinPoint.proceed();
		} finally {
			long finish = System.currentTimeMillis();
			long timeMs = finish - start;
			System.out.println("END: "+joinPoint.toShortString()+" "+timeMs+"ms");
		}
	}

}
