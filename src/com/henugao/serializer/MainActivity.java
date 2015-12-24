package com.henugao.serializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import com.henugao.geneatexml.domain.Message;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Xml;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	List<Message> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list = new ArrayList<Message>();
		//�������ʮ������
		for (int i = 0; i < 10; i++) {
			Message msg = new Message("00"+i+"���ǵ�"+i+"��", System.currentTimeMillis()+"", "1378115098"+i, "1");
			list.add(msg);
		}
	}

	
	public void click(View v){
		//ʹ�����л�������xml�ļ�
		//1���õ�xml���л�������
		XmlSerializer xs = Xml.newSerializer();
		//2���������л����������
		File file = new File(Environment.getExternalStorageDirectory(),"msg1.xml");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			xs.setOutput(fos, "utf-8");
			//3����ʼ����xml�ļ�
			xs.startDocument("utf-8", true);
			xs.startTag(null, "message");
			for (int i = 0; i < list.size(); i++) {
				xs.startTag(null, "smss");
				xs.startTag(null, "body");
				xs.text(list.get(i).getBody());
				xs.endTag(null, "body");
				xs.startTag(null, "date");
				xs.text(list.get(i).getDate());
				xs.endTag(null, "date");
				xs.startTag(null, "address");
				xs.text(list.get(i).getAddress());
				xs.endTag(null, "address");
				xs.startTag(null, "type");
				xs.text(list.get(i).getType());
				xs.endTag(null, "type");
				xs.endTag(null, "smss");
			}
			xs.endTag(null, "message");
			xs.endDocument();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
