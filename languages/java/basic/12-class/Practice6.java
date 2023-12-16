
public class Practice6 {

	public static void main(String[] args) {
		
		Compute[] compute = new Compute[3];
		
		for(int a=0; a<compute.length; a++) {
			compute[a] = new Compute();
		}
		
		compute[0].setX(320);
		compute[0].setY(258);
		compute[1].setX(256);
		compute[1].setY(125);
		compute[2].setX(452);
		compute[2].setY(365);
		
		compute[0].outputTitle();
		
		for(int a=0; a<compute.length; a++) {
			compute[a].getSum();
			compute[a].getSub();
			compute[a].getMul();
			compute[a].getDiv();	
			compute[a].outputCalc();
		}		
		
	}

}
