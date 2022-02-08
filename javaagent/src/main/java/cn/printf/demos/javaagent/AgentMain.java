package cn.printf.demos.javaagent;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.io.PrintStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class AgentMain {
    public static void premain(String arguments, Instrumentation instrumentation) {
        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                if (className.equals("cn/printf/demos/helloworld/Application")) {
                    System.out.println("transform class: " + className);
                    System.out.println("transform class: " + className);

                    ClassReader reader = new ClassReader(classfileBuffer);
                    ClassWriter writer = new ClassWriter(reader, ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);
                    reader.accept(new MyClassVisitor(writer), ClassReader.EXPAND_FRAMES);
                    System.out.println(writer.toString());

                    return writer.toByteArray();
                }
                return new byte[0];
            }
        });
    }

    public static class MyClassVisitor extends ClassAdapter {

        public MyClassVisitor(ClassVisitor classVisitor) {
            super(classVisitor);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            MethodVisitor methodVisitor = super.visitMethod(access, name, desc, signature, exceptions);
            if (name.equals("main")) {
                return new MyMethodVisitor(methodVisitor, name);
            } else {
                return methodVisitor;
            }
        }
    }

    private static class MyMethodVisitor extends MethodAdapter {
        private final String name;

        public MyMethodVisitor(MethodVisitor methodVisitor, String name) {
            super(methodVisitor);
            this.name = name;
        }

        @Override
        public void visitCode() {
            super.visitCode();
            mv.visitFieldInsn(
                    Opcodes.GETSTATIC,
                    Type.getInternalName(System.class),
                    "out",
                    Type.getDescriptor(PrintStream.class)
            );
            mv.visitLdcInsn("hack by asm for method: " + name);
            mv.visitMethodInsn(
                    Opcodes.INVOKEVIRTUAL,
                    Type.getInternalName(PrintStream.class),
                    "println",
                    "(Ljava/lang/String;)V"
            );
        }
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("Agent started！");
        System.out.println("agentmain");
    }
}
