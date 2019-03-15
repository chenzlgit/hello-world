import java.io.File;
 
public class delFile {
 
	/**
	 * ������ -����IPhone�ֻ���������Ƭ�ļ����Ż����Դ�ļ�
	 * @author Colin
	 * 	 * @param args
	 */
	public static void main(String[] args) {
		String srcFilePath = "E:\\Image\\APPLE";
        String newFilePath = "E:\\Image\\APPLE\\BAK";//����Ŀ¼
        try {
        	System.out.println("/**********BGN**********/");
        	fileMove(srcFilePath, newFilePath);
        	System.out.println("/**********END**********/");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
 
	/**
     * ɸѡ�ļ�
     * @param srcFilePath      Ҫ�ƶ����ļ�Ŀ¼
     * @param newFilePath      Ŀ���ļ�Ŀ¼
     * @throws Exception
     */
    public static void fileMove(String srcFilePath, String newFilePath) throws Exception {
        try {
            File dir = new File(srcFilePath);
            // �ļ�һ��
            File[] files = dir.listFiles();
            if (files.length<0){
                System.out.println("Ҫ�ƶ����ļ���û�����ݣ�");
                return;
            }
            // Ŀ��
            File moveDir = new File(newFilePath);
            if (!moveDir.exists()) {
                moveDir.mkdirs();
            }
            // �ļ��ƶ�
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    fileMove(files[i].getPath(), newFilePath + "\\" + files[i].getName());
                    // �ɹ���ɾ��ԭ�ļ�
                    files[i].delete();
                }
                String filename=files[i].getName();
                if(filename.indexOf("E.JPG")>0)
                {
                	String filename_old=filename.replace("E.JPG", ".JPG");
                	File file_old=new File(dir.getPath() + "\\" + filename_old);
                	File moveFile = new File(moveDir.getPath() + "\\" + filename_old);
                    if (file_old.exists()) {
                    	System.out.println("�޳��ظ�Դ�ļ�"+filename_old);
                    	file_old.renameTo(moveFile);
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}