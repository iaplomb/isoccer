import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * 生成随机数Service 
 */
public class RandomService {

	public static Random random = new Random();
	
	/**
	 * 是否在范围内 如(5/100)则有5%几率返回值为true
	 * @param minPercent 分子
	 * @param maxPercent 分母
	 * @return 是否在范围内
	 */
	public static boolean isInTheLimits(Integer minPercent, Integer maxPercent) {
		if (random.nextInt(maxPercent)+1<=minPercent) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 生成length个数量的随机数，每个随机数的最大值为maxNum，最小值为1
	 * @param maxNum
	 * @param length
	 * @return
	 */
	public static List<Byte> generateRandomArray(int maxNum, int length) {
		List<Byte> randomList = new ArrayList<Byte>();
		int count = 0;
		while( count < length ){
			randomList.add( (byte)random.nextInt(maxNum+1));
			count++;
		} 
		return randomList;
	}
	
	/**
	 * 生成随机数字数组
	 * @param maxNum 最大数字范围(0~maxNum)
	 * @param length 长度
	 * @return int数组(按照从小到大自动排序)
	 */
	public static int[] generateRandomNumberArray(int maxNum, int length) {
		int[] randomArray = new int[length];
		Set<Integer> set = new TreeSet<Integer>();
		while(true){
			set.add(random.nextInt(maxNum+1));
			if(set.size()>=length){
				break;
			}
		}
		Iterator<Integer> iterator = set.iterator();
		int i = 0;
		while(iterator.hasNext()){
			randomArray[i] = iterator.next();
			i++;
		}
		return randomArray;
	}
	
	public static int[] randomIndexFromList(List<Integer> indexList,int length){
		int[] randomArray = new int[length];
		Set<Integer> set = new TreeSet<Integer>();
		while(true) {
			int index = random.nextInt(indexList.size());
			set.add( indexList.get(index) );
			indexList.remove(index);
			if(set.size()>=length){
				break;
			}
		}
		
		Iterator<Integer> iterator = set.iterator();
		int i = 0;
		while(iterator.hasNext()){
			randomArray[i] = iterator.next();
			i++;
		}
		
		return randomArray;
	}
	
	/**
	 * 生成随机数字数组(大于等于minNum且小于等于maxNum)
	 * @param minNum
	 * @param maxNum
	 * @param length
	 * @return int数组(按照从小到大自动排序)
	 */
	public static int[] generateRandomNumberArray(int minNum, int maxNum, int length) {
		int[] randomArray = new int[length];
		Set<Integer> set = new TreeSet<Integer>();
		int offset = maxNum-minNum;
		while(true){
			set.add(random.nextInt(offset)+minNum+1);
			if(set.size()>=length){
				break;
			}
		}
		Iterator<Integer> iterator = set.iterator();
		int i = 0;
		while(iterator.hasNext()){
			randomArray[i] = iterator.next();
			i++;
		}
		return randomArray;
	}
	
	/**
	 * 
	 * @param minNum
	 * @param maxNum
	 * @param length
	 * @return
	 */
	public static int[] generateRandomNumberArray2(int minNum, int maxNum, int length) {
		int[] randomArray = new int[length];
		int start = random.nextInt(maxNum)+1;
		for(int i=0;i<length;i++) {
			randomArray[i] = (start + i)%maxNum+minNum;
		}
		return randomArray;
	}
	
	/**
	 * 生成随机数字数组(大于等于minNum且小于等于maxNum)
	 * @param minNum
	 * @param maxNum
	 * @param length
	 * @return int数组(按照从小到大自动排序)
	 */
	public static int[] generateNumberArray(int minNum, int maxNum, int length) {
		int[] randomArray = new int[length];
		Set<Integer> set = new TreeSet<Integer>();
		int min = minNum<maxNum?minNum:maxNum;
		int offset = Math.abs(maxNum-minNum);
		int i = 0;
		while(true){
			int tmp = offset==0?min:random.nextInt(offset)+min;
			if ( set.add( tmp ) ) {
				randomArray[i++] = tmp;
			}
			if(set.size()>=length){
				break;
			}
		}
		return randomArray;
	}
	
	/**
	 * 在已存在数据中随机选取数字
	 * @param existingArray 已存在数组
	 * @param num 数量
	 * @return
	 */
	public static int[] generateRandomNumberArrayFromExistingArray(Integer[] existingArray, int num){
		int[] randomArray = new int[num];
		Set<Integer> set = new TreeSet<Integer>();
		while(true){
			set.add(existingArray[random.nextInt(existingArray.length)]);
			if(set.size()>=num){
				break;
			}
		}
		Iterator<Integer> iterator = set.iterator();
		int i = 0;
		while(iterator.hasNext()){
			randomArray[i] = iterator.next();
			i++;
		}
		return randomArray;
	}

	public static int getRandomNumber(int len) {
		return random.nextInt(len) ;
	}
	
	/**
	 * 许愿树生成随机数
	 * */
	public static int getRandomPrayTree(int len) {
		return random.nextInt(len) + 1;
	}
	
	/**
	 * 星尘召唤生成随机数,生成星尘数量
	 * */
	public static int getRandomStartCall(int len) {
		int randomNumber =  random.nextInt(len) + 1;
		if(randomNumber <= 2) {
			return 9;
		}else if(randomNumber <= 10) {
			return 5 + random.nextInt(3);
		} else {
			return random.nextInt(3) + 1;
		}
	}
	
	/**
	 * 星尘召唤生成随机位置
	 * */
	public static int getRandomStartCallEX(int len) {
		int randomNumber =  random.nextInt(len) + 1;
		return randomNumber;
	}
	
	public static boolean isInArray(int[] array, int e) {
		for (int i:array) {
			if (i==e) {
				return true;
			}
		}
		return false;
	}
	
	public static <T> T getOneRandomElement(Collection<T> coll) {
		int length = coll.size();
		int sel = getRandomNumber(length);
		int i = 0;
		for(T one:coll){
			if (sel == i)
				return one;
			//sel++;
			i++;
		}
		return null;
	}
	
	/**
	 * 随机出value~value*N之间的整数，precision指定精度
	 * 例如：将value=1000，在100%~200%内随机，精度1% 则这样调用randomMultipleN(1000,2,2)
	 * @param value       需要随机出倍数的值
	 * @param maxMultiple 倍数         >1
	 * @param precision   指定精度 >=1
	 * @return
	 */
	public static int randomMultipleN(int value, int maxMultiple, int precision) 
	{
		//精度值
		int precisionValue = (int)Math.pow(10, precision);
		//因子范围
		int factorRange = precisionValue * (maxMultiple-1);
		int factor = RandomService.getRandomNumber(factorRange + 1);
		
		double temp = value + value * factor / precisionValue;
		int result = (int)Math.round(temp); //四舍五入
		return result;
	}	
	
	/**
	 * 产生min与max之间的一个随机整数
	 * @param min
	 * @param max
	 * @return
	 * @Added by 500
	 */
	public static int randomBetween(int min, int max) {
		if ( min >= max ) return min;
		return random.nextInt(max - min+1 ) + min ;
	}
	
	public static void main(String[] args) {
		List<Integer> indexList = new ArrayList<Integer>();
		for( int k=0;k<8;k++)indexList.add(k);
		int[] a = randomIndexFromList( indexList, 2);
		System.out.println(  a[0]  + "," +  a[1] );
		a = randomIndexFromList( indexList, 2);
		System.out.println(   a[0]  + "," +  a[1]  );
		a = randomIndexFromList( indexList, 2);
		System.out.println(   a[0]  + "," +  a[1]  );
		System.out.println(indexList.size());
		
//		int a = 0;
//		for ( int i=0;i<100;i++) {
//			if ( isInTheLimits(1,10) ) a++;
//		}
//		System.out.println(a);
//		int[] a = generateNumberArray(16,14,9);
//		for( int b:a)
//			System.out.print(b+",");
//		int[] a = generateNumberArray(1, 4, 4);
//		System.out.println(a.length);
//		for ( int i=0;i<100;i++) {
//			System.out.println(randomMultipleN(6,2,2));
//		}
	}
}
