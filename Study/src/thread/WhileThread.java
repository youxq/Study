package thread;

public class WhileThread extends Thread{

	private int i;
	
	public WhileThread(int i){
		this.i = i;
	}
	public void run(){
		boolean flag = true;
		while(flag){
			try{
				flag = false;
				test();
			}catch(Exception e){
				flag = true;
			}
			
		}
	}
	
	public static void main(String[] args){

		for(int i=0;i<10;i++){
			new WhileThread(i).start();
		}
	}
	
	private void test() throws Exception{
		double temp = Math.random()*10;
		
		if(temp<=10){
			System.out.println("exception " + i);
			throw new Exception();			
		}
		System.out.println("success " + i);
	}
}
