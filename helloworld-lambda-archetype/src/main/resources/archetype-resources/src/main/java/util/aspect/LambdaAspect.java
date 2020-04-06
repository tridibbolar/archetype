package ${groupId}.util.aspect;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
 
@Aspect
public class LambdaAspect {
	static final Logger LOG = LogManager.getLogger(LambdaAspect.class);
	//Useful link
	//https://blog.espenberntsen.net/2010/03/20/aspectj-cheat-sheet/
	
	//Patterns
    //!private = look for any modifier thats not private
    //!void = looking for method with no void
    //com.cts.tnh.gee.lambda.config.YourClass.yourMethodBefore(..) = PackageName . ClassName . methodName (parameters)
    //@Around("execution (!private !void com.cts.tnh.gee.lambda.config.GEEDBConfigurationFunctionHandler.*(..))")
    @Around("execution (!private !void ${groupId}.service.${service}Service.*(..))")
    //ProceedingJointPoint = the reference of the call to the method.
    //Difference between ProceedingJointPoint and JointPoint is that a JointPoint cant be continued(proceeded)
    //A ProceedingJointPoint can be continued(proceeded) and is needed for a Around advice
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        //Default Object that we can use to return to the consumer
        Object returnObject = null;
        Date start = null;
        final Signature signature = joinPoint.getSignature();
        final String clazz = signature.getDeclaringTypeName();
        final String methodName = signature.getName();
        try {
            LOG.info("[AJ] Method " + clazz+"::"+methodName+" started");
            start = new Date();
            //We choose to continue the call to the method in question
            returnObject = joinPoint.proceed();
            //If no exception is thrown we should land here and we can modify the returnObject, if we want to.
        } catch (Throwable throwable) {
            //Here we can catch and modify any exceptions that are called
            //We could potentially not throw the exception to the caller and instead return "null" or a default object.
            throw throwable;
        }
        finally {
            //If we want to be sure that some of our code is executed even if we get an exception
        	Date end = new Date();
            LOG.info("[AJ] Elapsed time of "+clazz+"::"+methodName+" is "+(end.getTime()-start.getTime())+" ms");
        }
 
        return returnObject;
    }
    
	// Some other examples - DO NOT DELETE
	
	//Patterns
    //blank = modifier (public/private/protected or default(blank) should be looked for
    //* = return type to look for. Void/Object
    //com.cts.tnh.gee.lambda.config.YourClass.yourMethodBefore(..) = PackageName . ClassName . methodName (parameters)
	//JointPoint = the reference of the call to the method
	/*@Before("execution (* com.cts.tnh.gee.lambda.config.GEEDBConfigurationFunctionHandler.handleRequest(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        LOG.info("YourAspect's BeforeAdvice's body is now executed Before yourMethodBefore is called FROM LOGGER.");
    }*/
	
    //Patterns
    //public = look for the specific modifier named public
    //Object = Basically we are looking for void or primitives. But if we specified Object we could get a good pattern
    //com.cts.tnh.gee.lambda.config.YourClass.yourMethodBefore(..) = PackageName . ClassName . methodName (parameters)
    /*@After("execution (public JSONObject com.cts.tnh.gee.lambda.config.GEEDBConfigurationFunctionHandler.handleRequest(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        LOG.info("YourAspect's afterAdvice's body is now executed After yourMethodAfter is called FROM LOGGER.");
    }*/
    
    //Patterns//* = return type to look for. Void/Object/Primitive type
    //blank = modifier (public/private/protected or default(blank) should be looked for
    //* = return type to look for. Void/Object/Primitive type
    //com.cts.tnh.gee.lambda.config.YourClass.yourMethod*(..) = PackageName . ClassName . * (parameters)
    //Where the "*" will catch any method name
    //JointPoint = the reference of the call to the method
    /*@After("execution ( * com.cts.tnh.gee.lambda.config.YourClass.*(..))")
    public void printNewLine(JoinPoint pointcut){
        //Just prints new lines after each method that's executed in
        System.out.print("\n\r");
    }*/
}