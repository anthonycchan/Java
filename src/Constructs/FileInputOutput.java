package Constructs;

import java.io.*;

class ToLowerCaseInputStream extends FilterInputStream {

	protected ToLowerCaseInputStream(InputStream arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase( (char)c) );
	}
}

class FileTest {
	FileTest() {
	}
	
	// 
	// input.txt must be created first
	//
	public void testByteStream() throws IOException
	{
		FileInputStream fis = null;
//		ToLowerCaseInputStream fis = null;
		FileOutputStream fos = null;
		
		try {			
			File inputFile = new File("C:\\output\\input.txt");

			if( !inputFile.exists() )
			{
				System.out.println("Please create input.txt");
				return;
			}
			
			fis = new FileInputStream(inputFile);
//			fis = new ToLowerCaseInputStream( new FileInputStream(inputFile) );
			fos = new FileOutputStream("C:\\output\\output.txt");
			
			int c;
			while (( c = fis.read() ) != -1){
				fos.write(c);
			}
		}
		finally{
			if ( fis != null )
				fis.close();
			if ( fos != null )
				fos.close();
		}
	}
	
	public void testCharacterStream() throws IOException
	{
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			File inputFile = new File("C:\\output\\input.txt");
			if ( !inputFile.exists() )
			{
				System.out.println("Please create input.txt");
				return;
			}
			
			fr = new FileReader(inputFile);
			fw = new FileWriter("C:\\output\\output.txt");
			
			int c;
			while ( (c = fr.read()) != -1 ) {
				fw.write(c);
			}
		}
		finally {
			if ( fr != null )
				fr.close();
			if ( fw != null )
				fw.close();
		}
	}
	
	public void testStandardStream() throws IOException
	{
		InputStreamReader isr = null;
		
		try {
			isr = new InputStreamReader(System.in);
			
			char c;
			
			do {
				c = (char) isr.read(); // read from keyboard (cin)
				
			}while(c != 'q');
			
			System.out.println("end");
		}
		finally {
			if ( isr != null )
			{
				isr.close();
			}
		}
	}
	
	public void testDataInputOutputStream() throws IOException
	{					
		DataOutputStream dos = new DataOutputStream( new FileOutputStream("C:\\output\\DataStream.bin") );
		dos.writeUTF("Data input stream test");
		dos.close();

		DataInputStream dis = new DataInputStream( new FileInputStream("C:\\output\\DataStream.bin") );
		System.out.println(dis.readUTF());
		dis.close();
	}
	
	public void testFileDirectory() throws IOException
	{
		// Create directory
		String str = "C:\\output\\testDir";
		File file1 = new File(str);
		file1.mkdirs();
		
		// List files in the directory
		File file2 = new File("C:\\output");
		String fileList[] = file2.list();

		DataOutputStream dis = new DataOutputStream(new FileOutputStream("C:\\output\\FileList.bin"));
		for ( String str2 : fileList )
		{
			dis.writeUTF(str2);
		}
		dis.close();
	}
}

public class FileInputOutput {

	public FileInputOutput() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		FileTest ft = new FileTest();
		
		ft.testByteStream();
		ft.testCharacterStream();
		//ft.testStandardStream();
		ft.testDataInputOutputStream();
		ft.testFileDirectory();
	}

}
