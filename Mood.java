package Progra2.Interfaz;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import org.json.*;

public class Mood {
	ToneAnalyzer toneAnalyzer = new ToneAnalyzer(ToneAnalyzer.VERSION_DATE_2016_05_19);

	public void setCredentials() {
		toneAnalyzer.setUsernameAndPassword("3de42be9-db6a-475c-8fff-b83bd2571733", "M2blf3JOuuAJ");
	}

	public String analyze(String textIns, ToneOptions options) {
		return toneAnalyzer.getTone(textIns, options).execute().toString();
	}

	public static void main(String[] args) {

		String text = "happy";
		ToneOptions toneOptions = new ToneOptions.Builder().build();

		Mood mood = new Mood();
		mood.setCredentials();
		Object fin=mood.analyze(text, toneOptions);
		System.out.println(fin);
		
		
		/*JSONObject obj = new JSONObject(fin);
		JSONObject pageName = obj.getJSONObject("document_tone");
		
		//JSONArray arr0 = obj.getJSONArray("tones");
		JSONArray arr = obj.getJSONArray("tone_categories");
		for (int i = 0; i < arr.length(); i++)
		{
		    String Tone_id = arr.getJSONObject(i).getString("tone_id");
		    System.out.println(Tone_id);
		    String Tone_name = arr.getJSONObject(i).getString("tone_name");
		    System.out.println(Tone_name);
		    String Score = arr.getJSONObject(i).getString("score");
		    System.out.println(Score);
		}
		*/
		
	}
}
