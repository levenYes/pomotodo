package cn.liwenye.cache;

public class CacheSingleton {
	@SuppressWarnings("unused")
	private static int numOfPomosSent = 0;
	
	private static class SingletonHolder {
		public static final CacheSingleton cacheSingleton = new CacheSingleton();
	}
	
	private CacheSingleton() {
	}
	
	public static CacheSingleton getCacheSingleton() {
		return SingletonHolder.cacheSingleton;
	}

	public static int getNumOfPomosSent() {
		return numOfPomosSent;
	}

	public static void setNumOfPomosSent(int numOfPomosSent) {
		CacheSingleton.numOfPomosSent = numOfPomosSent;
	}
}
