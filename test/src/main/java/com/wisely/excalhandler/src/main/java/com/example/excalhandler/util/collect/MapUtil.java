package com.example.excalhandler.util.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtil {

	public static <K, V> Map<K, List<V>> transformListToMapList(List<V> source, Function<K, V> func) {
		if (source == null) {
			return new HashMap<K, List<V>>();
		}
		Map<K, List<V>> result = new HashMap<K, List<V>>();
		for (V map : source) {
			K tempKey = func.apply(map);
			List<V> temp = result.get(tempKey);
			if (temp == null) {
				temp = new ArrayList<V>();
			}
			temp.add(map);
			result.put(tempKey, temp);
		}
		return result;
	}

	public static <K, V> Map<K, V> transformListToMap(List<V> source, Function<K, V> func) {
		if (source == null) {
			return new HashMap<K, V>();
		}
		Map<K, V> result = new HashMap<K, V>();
		for (V map : source) {
			K tempKey = func.apply(map);
			result.put(tempKey, map);
		}
		return result;
	}

}
