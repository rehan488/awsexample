import com.jcraft.jsch.*;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.nio.channels.Channel;

public class FileTransfer {

	public FileTransfer() {
		// super();
	}

	public static void main(String[] args) {
		FileTransfer fileTransfer = new FileTransfer();

		JSch jsch = new JSch();

		try {

			String host = "212.129.63.220";
            String user = "indictrans";
            String password = "H54GWRDXrhpBxRTL";
            int port = 22;
         
            try
            {
               
                Session session = jsch.getSession(user, host, port);
                session.setPassword(password);
                session.setConfig("StrictHostKeyChecking", "No");
                System.out.println("Establishing Connection...");
                session.connect();
                System.out.println("Connection established.");
                System.out.println("Crating SFTP Channel.");
                ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
                sftpChannel.connect();
                
            

                System.out.println("Connection established."+sftpChannel.getHome());
                session.disconnect();
                sftpChannel.disconnect();
            }
            catch (JSchException e)
            {
            	System.out.println("Failed "+e);
            } 
            
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}


	
	/*public void download(String fileName, String localDir) {

		byte[] buffer = new byte[1024];
		BufferedInputStream bis;
		connect();
		try {
			// Change to output directory
			String cdDir = fileName.substring(0, fileName.lastIndexOf("/") + 1);
			sftpChannel.cd(cdDir);

			File file = new File(fileName);
			bis = new BufferedInputStream(sftpChannel.get(file.getName()));

			File newFile = new File(localDir + "/" + file.getName());
			
			// Download file
			OutputStream os = new FileOutputStream(newFile);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			int readCount;
			while ((readCount = bis.read(buffer)) > 0) {
				bos.write(buffer, 0, readCount);
			}
			bis.close();
			bos.close();
			System.out.println("File downloaded successfully - "+ file.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		}
		disconnect();
	}*/


}