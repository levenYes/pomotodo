package cn.liwenye.cache;

public class CacheSingleton {
	private static int numOfTechPomosSent = 0;

	private static int numOfReadPomosSent = 0;
	
	private static class SingletonHolder {
		public static final CacheSingleton cacheSingleton = new CacheSingleton();
	}
	
	private CacheSingleton() {
	}
	
	public static CacheSingleton getCacheSingleton() {
		return SingletonHolder.cacheSingleton;
	}

	public static int getNumOfTechPomosSent() {
		return numOfTechPomosSent;
	}

	public static void setNumOfTechPomosSent(int numOfTechPomosSent) {
		CacheSingleton.numOfTechPomosSent = numOfTechPomosSent;
	}

	public static int getNumOfReadPomosSent() {
		return numOfReadPomosSent;
	}

	public static void setNumOfReadPomosSent(int numOfReadPomosSent) {
		CacheSingleton.numOfReadPomosSent = numOfReadPomosSent;
	}
}
