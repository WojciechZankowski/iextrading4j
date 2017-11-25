package pl.zankowski.iextrading4j.test.design;

import javassist.bytecode.ClassFile;
import org.reflections.scanners.AbstractScanner;

public class ViolationsScanner extends AbstractScanner {

    private final IDesignRules designRules;

    public ViolationsScanner(IDesignRules designRules) {
        this.designRules = designRules;
    }

    @Override
    public void scan(Object object) {
        final String className = this.getMetadataAdapter().getClassName(object);

        final ClassLoader clazzLoader = this.getClass().getClassLoader();
        final Class<?> clazz = getClazz(clazzLoader, className);

        DesignRuleInput input = new DesignRuleInput((ClassFile) object, clazz, clazzLoader, className, this.getStore());

        this.designRules.getDesignRules().forEach(designRule -> designRule.check(input));
    }

    private Class<?> getClazz(ClassLoader clazzLoader, String clazzName) {
        try {
            return clazzLoader.loadClass(clazzName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
