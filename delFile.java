import java.io.File;
 
public class delFile {
 
	/**
	 * 主方法 -处理IPhone手机导出的照片文件中优化后的源文件
	 * @author Colin
	 * 	 * @param args
	 */
	public static void main(String[] args) {
		String srcFilePath = "E:\\Image\\APPLE";
        String newFilePath = "E:\\Image\\APPLE\\BAK";//备份目录
        try {
        	System.out.println("/**********BGN**********/");
        	fileMove(srcFilePath, newFilePath);
        	System.out.println("/**********END**********/");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
 
	/**
     * 筛选文件
     * @param srcFilePath      要移动的文件目录
     * @param newFilePath      目标文件目录
     * @throws Exception
     */
    public static void fileMove(String srcFilePath, String newFilePath) throws Exception {
        try {
            File dir = new File(srcFilePath);
            // 文件一览
            File[] files = dir.listFiles();
            if (files.length<0){
                System.out.println("要移动的文件夹没有内容！");
                return;
            }
            // 目标
            File moveDir = new File(newFilePath);
            if (!moveDir.exists()) {
                moveDir.mkdirs();
            }
            // 文件移动
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    fileMove(files[i].getPath(), newFilePath + "\\" + files[i].getName());
                    // 成功，删除原文件
                    files[i].delete();
                }
                String filename=files[i].getName();
                if(filename.indexOf("E.JPG")>0)
                {
                	String filename_old=filename.replace("E.JPG", ".JPG");
                	File file_old=new File(dir.getPath() + "\\" + filename_old);
                	File moveFile = new File(moveDir.getPath() + "\\" + filename_old);
                    if (file_old.exists()) {
                    	System.out.println("剔除重复源文件"+filename_old);
                    	file_old.renameTo(moveFile);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}