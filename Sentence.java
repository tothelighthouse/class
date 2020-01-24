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
		//���� ���̰� ª�� target�� keyset�� ���
		//���̰� �� orderFrame�� keyset�� �����Ͽ�(byŰ�� �߰� �Ǿ��� ������)
		//���̰� ª�� target�� �������� ���̰� �� orderFrame�� keyset�� �ϳ��� target�� ���Ͽ�
		//target�� keyset�� orderFrame�� �����ϴ� Ű���� �������� �ʴ� ��쿡��
		//target�� Ű���� orderFrame�� Ű������ value���� Ű������ �ϴ� map ��� �ϳ��� �߰��Ѵ�.
		String addItem = null;
		int i = 0;
		for(String targetKey : target.keySet()) {
			System.out.println("targetKey�� �� = " + targetKey);
			for(String orderFrameKey : orderFrame.keySet()) {
				addItem = orderFrameKey;
				System.out.println("addItem�� ��" + addItem);
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

		System.out.println("orderFrame.size�� ���� =" + orderFrame.size());
		//target�� Ű���� �޾ƿͼ� orderFrame get() �Լ��� �ϳ��� �����Ͽ�
		//�ش��ϴ� value�� ���� ������ ����Ʈ�� index�� �����Ͽ� 
		//target�� value�� �ϳ��� �����Ѵ�.
		for(Map.Entry<String, String> keyValue :target.entrySet()) {

			int index = orderFrame.get(keyValue.getKey());
			result.add(keyValue.getValue());
		}
		return result;
	}
}







































