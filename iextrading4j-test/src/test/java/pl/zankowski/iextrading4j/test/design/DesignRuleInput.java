package pl.zankowski.iextrading4j.test.design;

import com.google.common.collect.Multimap;
import javassist.bytecode.ClassFile;

public class DesignRuleInput {

    private final ClassFile clazzFile;
    private final Class<?> clazz;
    private final ClassLoader classLoader;
    private final String clazzName;
    private final Multimap<String, String> store;

    public DesignRuleInput(ClassFile clazzFile, Class<?> clazz, ClassLoader classLoader, String clazzName, Multimap<String, String> store) {
        this.clazzFile = clazzFile;
        this.clazz = clazz;
        this.classLoader = classLoader;
        this.clazzName = clazzName;
        this.store = store;
    }

    public ClassFile getClazzFile() {
        return clazzFile;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public String getClazzName() {
        return clazzName;
    }

    public Multimap<String, String> getStore() {
        return store;
    }

}
