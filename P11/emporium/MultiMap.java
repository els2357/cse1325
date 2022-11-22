package emporium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Container;
import product.Order;
import product.Serving;
import product.Scoop;
import person.Person;
import person.Customer;

public class MultiMap<K, V>{
	private HashMap< K, HashSet<V> > map = new HashMap<>();
	
	public void put(K key, V value){
		if (map.get(key) == null){
			map.put(key, new HashSet<V>());
		}
		map.get(key).add(value);
	}
	
	public Object[] get(K key){
		if (map.get(key) == null){
			return null;
		}
		return map.get(key).toArray();
	}
}
