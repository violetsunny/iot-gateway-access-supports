package cn.enncloud.iot.gateway.utils;
 
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
 
/**
 * @ClassName DeployJar
 * @Author hanyilong@enn.cn
 *
 */
 
public class DeployJar {
	// 后缀
	private final static String CLAZZ_SUFFIX = ".class";
 
	// 类加载器
	private static ClassLoader classLoader;
 
	/**
	 * @Title loadPath
	 * @Description 创建加载器
	 * @param jarPath
	 *            jar包所在路经
	 * @throws
	 */
	public static void loadPath(String jarPath) {
		try {
			File jarFiles = new File(jarPath);
 
			File[] jarFilesArr = jarFiles.listFiles();
			URL[] jarFilePathArr = new URL[jarFilesArr.length];
			int i = 0;
			for (File jarfile : jarFilesArr) {
				String jarname = jarfile.getName();
				if (jarname.indexOf(".jar") < 0) {
					continue;
				}
				String jarFilePath = "file:\\" + jarPath + File.separator
						+ jarname;
				jarFilePathArr[i] = new URL(jarFilePath);
				i++;
			}
 
			classLoader = new URLClassLoader(jarFilePathArr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	/**
	 * @Title loadJar
	 * @Description 遍历jar包下的类
	 * @param jarName
	 *            jar包名字 完整路径
	 * @throws
	 */
	public static void loadJar(String jarName) {
		if (jarName.indexOf(".jar") < 0) {
			return;
		}
		try {
			JarFile jarFile = new JarFile(jarName);
			Enumeration<JarEntry> em = jarFile.entries();
			while (em.hasMoreElements()) {
				JarEntry jarEntry = em.nextElement();
				String clazzFile = jarEntry.getName();
 
				if (!clazzFile.endsWith(CLAZZ_SUFFIX)) {
					continue;
				}
				String clazzName = clazzFile.substring(0,
						clazzFile.length() - CLAZZ_SUFFIX.length()).replace(
						'/', '.');
				System.out.println(clazzName);
 
				loadClass(clazzName);
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	/**
	 * @Title loadClass
	 * @Description 通过类加载器实例化
	 * @param clazzName
	 *            类名字
	 * @return
	 * @throws
	 */
	public static Object loadClass(String clazzName) {
		if (classLoader == null) {
			return null;
		}
		Class clazz = null;
		try {
			clazz = classLoader.loadClass(clazzName);
			Object obj = clazz.newInstance();
			return obj;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoClassDefFoundError e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}