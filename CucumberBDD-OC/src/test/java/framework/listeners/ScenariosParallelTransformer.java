package framework.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IDataProviderAnnotation;

import java.lang.reflect.Method;

/**
 * This listener will be used to control the parallelism of scenarios for each test in TestNG suite xml.
 * The scenarios will run in parallel if the system property scenariosInParallel is provided as true from maven
 * Else by default the scenarios will run sequentially
 */
public class ScenariosParallelTransformer implements IAnnotationTransformer {

    @Override
    public void transform(IDataProviderAnnotation annotation, Method method) {
        boolean runInParallel = Boolean.getBoolean("scenariosInParallel");
        if (runInParallel) {
            annotation.setParallel(true);
        }
    }
}
