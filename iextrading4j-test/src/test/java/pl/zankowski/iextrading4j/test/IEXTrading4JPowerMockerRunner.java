package pl.zankowski.iextrading4j.test;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.bytecode.AccessFlag;
import org.powermock.modules.junit4.PowerMockRunner;

public class IEXTrading4JPowerMockerRunner extends PowerMockRunner {

    static {
        final ClassPool cp = ClassPool.getDefault();
        try {
            final CtClass mockFactoryClass = cp.get("org.powermock.core.classloader.javassist.JavaAssistClassMarkerFactory");
            final CtClass classPoolClass = cp.get(ClassPool.class.getName());

            final CtClass classLoaderFactoryClass = cp.get("org.powermock.core.classloader.MockClassLoaderFactory");
            final CtClass classLoaderClass = cp.get("java.lang.ClassLoader");

            final CtField defaultClassLoader = new CtField(classLoaderClass, "DEFAULT_CLASS_LOADER", classLoaderFactoryClass);
            defaultClassLoader.setModifiers(AccessFlag.STATIC);
            classLoaderFactoryClass.addField(defaultClassLoader);

            final CtMethod createMethod = classLoaderFactoryClass.getDeclaredMethod("create");
            createMethod.setModifiers(AccessFlag.SYNCHRONIZED);
            createMethod.setBody("{\n" +
                    "        final String[] classesToLoadByMockClassloader = this.makeSureArrayContainsTestClassName($2, this.testClass.getName());\n" +
                    "        if (DEFAULT_CLASS_LOADER == null) {\n" +
                    "            DEFAULT_CLASS_LOADER = this.createMockClassLoader($1, classesToLoadByMockClassloader, $3);\n" +
                    "        } else {\n" +
                    "            ((org.powermock.core.classloader.MockClassLoader)DEFAULT_CLASS_LOADER).getConfiguration().addClassesToModify(classesToLoadByMockClassloader);\n" +
                    "        }\n" +
                    "        return DEFAULT_CLASS_LOADER;\n" +
                    "    }");

            mockFactoryClass.defrost();
            classLoaderFactoryClass.toClass();

            classLoaderFactoryClass.detach();
            classLoaderClass.detach();
            classPoolClass.detach();
            mockFactoryClass.detach();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IEXTrading4JPowerMockerRunner(final Class<?> klass) throws Exception {
        super(klass);
    }
}
