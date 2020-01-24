import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;


public class Sentence {
	public static void main(String[] args) {
		Stream<String> list = Stream.of("I", "am","boy");
		//		list.filter(new Predicate<String>() {
		//			@Override
		//			public boolean test(String t) {if(t == "I") {return true;}return false;}
		//		}).forEach(i->System.out.println(i));


		//		String result = list.map(new Function<String, String>() {
		//			@Override
		//			public String apply(String t) {
		//				if(t == "am") {return "was";}else {return t;}
		//			}
		//		}).collect(joining(" "));
		//		System.out.println(result);

		//		String result = list.map(new Function<String, String>() {
		//			@Override
		//			public String apply(String t) {if(t == "am") {return "was";}return t;			}
		//		}).collect(joining(" "));
		//		System.out.println(result);
		HashMap<String, Integer> orderFrame = new HashMap<>();
		orderFrame.put("subject", 0);
		orderFrame.put("verb", 1);
		orderFrame.put("by", 2);
		orderFrame.put("object", 3);
		HashMap<String, String> sentence = new HashMap<>();
		sentence.put("object", "family");
		sentence.put("verb", "hit");
		sentence.put("subject", "James");
		HashMap<String, String> pastSentence = Sentence.verbTrasform(sentence);
		HashMap<String, String> passiveSentence = Sentence.exchangeSubObj(pastSentence);
		System.out.println(passiveSentence);
		List<String> ordered = Sentence.orderSentence(orderFrame, passiveSentence);
		System.out.println(ordered);

	}
	public static <T> HashMap<T, T> verbTrasform(HashMap<T, T> input){
		String passiveVerb = "is " + input.get("verb") + "ed";
		input.remove("verb");
		input.put((T)"verb", (T)passiveVerb);
		return input;
	}
	public static <T> HashMap<T, T> exchangeSubObj(HashMap<T, T> input){
		T valueObj = input.get("object");
		T valueSub = input.get("subject");
		input.remove("subject");
		input.remove("object");
		input.put((T) "object", valueSub);
		input.put((T) "subject", valueObj);
		return input;
	}
	public static List<String> orderSentence(HashMap<String, Integer> orderFrame, HashMap<String, String> target) {
		//먼저 길이가 짧은 target의 keyset을 얻고
		//길이가 긴 orderFrame의 keyset을 추출하여(by키가 추가 되었기 때문에)
		//길이가 짧은 target을 기준으로 길이가 긴 orderFrame의 keyset을 하나씩 target과 비교하여
		//target의 keyset에 orderFrame에 존재하는 키값이 존재하지 않는 경우에는
		//target에 키값을 orderFrame의 키값으로 value값을 키값으로 하는 map 요소 하나를 추가한다.
		String addItem = null;
		int i = 0;
		for(String targetKey : target.keySet()) {
			System.out.println("targetKey의 값 = " + targetKey);
			for(String orderFrameKey : orderFrame.keySet()) {
				addItem = orderFrameKey;
				System.out.println("addItem의 값" + addItem);
				if(targetKey.equals(orderFrameKey)) {
					i = 0;
					break;
				}else {					
					i++;
				}
			}
			if(i != 0) {
				target.put(addItem, addItem);
			}
		}



		List<String> result = new ArrayList<>();

		System.out.println("orderFrame.size의 길이 =" + orderFrame.size());
		//target의 키셋을 받아와서 orderFrame get() 함수에 하나씩 대입하여
		//해당하는 value를 새로 생성된 리스트의 index로 지정하여 
		//target의 value를 하나씩 삽입한다.
		for(Map.Entry<String, String> keyValue :target.entrySet()) {

			int index = orderFrame.get(keyValue.getKey());
			result.add(keyValue.getValue());
		}
		return result;
	}
}







































