package common.filter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAdvice {
	@Pointcut(value = "execution(* admin.model.AdminUserDAOService.sele*(..))")
	private void pointcut2() {}
	@Before(value = "pointcut2()")
	public void logBefore(JoinPoint point) {
		System.out.print("before : at " + point.getTarget().getClass() + ".");
		System.out.print(point.getSignature().getName() + "() ");
		System.out.print("using " + point.getArgs()[0] + " ");
		System.out.println(": going into JoinPoint method");
	}
	@Around(value = "pointcut2()")
	public Object logAround(ProceedingJoinPoint pPoint) throws Throwable {
		System.out.print("around : at " + pPoint.getTarget().getClass() + ".");
		System.out.print(pPoint.getSignature().getName() + "() ");
		System.out.println("using " + pPoint.getArgs()[0] + " ");
		Object result = pPoint.proceed();
		System.out.println("around : result=" + result);
		return result;
	}
	@AfterReturning(pointcut = "pointcut2()", returning = "result")
	public void logAfter(JoinPoint point, Object result) {
		System.out.println("after : JoinPoint method finished, result="
				+ result);
	}
	@AfterThrowing(pointcut = "pointcut2()", throwing = "exception")
	public void logThrow(JoinPoint point, Throwable exception) {
		System.out
				.println("After Throwing--------------------------------------------------------Exception:"
						+ exception);
	}	
}


