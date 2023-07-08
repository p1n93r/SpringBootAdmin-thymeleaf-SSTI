package com.test.server;

import jdk.jshell.SnippetEvent;
import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

public class BasicTest {

    @Test
    public void testSSTI()throws Exception{
        String template = "file:///C:\\Users\\Eros\\Downloads\\backend\\hack.txt";

        TemplateEngine templateEngine = new TemplateEngine();
        Context ctx = new Context();
        ctx.setVariable("test", "111");
        String process = templateEngine.process(template, ctx);
        System.out.println("--------------------");
        System.out.println(process);
        System.out.println("--------------------");
    }

    @Test
    public void testClassBypass()throws Exception{
        new java.net.URL("http://baidu.com");
    }


    public static String getCharArrayStr(String text){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("new String (new char[]{");
        char[] chars = text.toCharArray();


        for (int i = 0; i < chars.length; i++) {
            char item = chars[i];
            stringBuilder.append((int)item);
            if(i != chars.length-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("});");
        return stringBuilder.toString();
    }



    @Test
    public void testGadget()throws Exception{



        jdk.jshell.JShell shell = jdk.jshell.JShell.create();
        List<SnippetEvent> eval = shell.eval("java.lang.Runtime.getRuntime().exec(\"calc\")");
        System.out.println(eval);

    }


}
