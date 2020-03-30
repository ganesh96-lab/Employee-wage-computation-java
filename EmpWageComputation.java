class EmpWageComputation
{
	//CONSTANTS
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=0;
	public final int EMP_RATE_PER_HRS;
	public final int NUM_WORKING_DAYS;	
	public final int MAX_HRS_IN_MONTH;

	public EmpWageComputation(int EMP_RATE_PER_HRS,int NUM_WORKING_DAYS,int MAX_HRS_IN_MONTH)
	{
		this.EMP_RATE_PER_HRS=EMP_RATE_PER_HRS;
		this.NUM_WORKING_DAYS=NUM_WORKING_DAYS;
		this.MAX_HRS_IN_MONTH=MAX_HRS_IN_MONTH;
	}
	public int calEmpWages()
	{
		//variables
		int empHrs=0,empWage=0,totalWorkingDays=0,
			totalEmpWage=0,totalEmpHrs=0;

		while (totalEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_WORKING_DAYS) 
		{
			totalWorkingDays++;
			int empCheck = ((int) Math.floor(Math.random() * 10)) % 3;
			switch(empCheck) 
			{
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				case IS_PART_TIME:
					empHrs = 4;
					break;
				default:
					empHrs = 0;
			}
			totalEmpHrs += empHrs;
			empWage = empHrs * EMP_RATE_PER_HRS;
			totalEmpWage += empWage;
		}
 		return totalEmpWage;
	}
	public static void main(String args[])
	{ 
		System.out.println("Welcome to Employee Wage Computation");
		EmpWageComputation bridgelabz=new EmpWageComputation(20,20,100);
		EmpWageComputation capgemini=new EmpWageComputation(20,20,100);
		EmpWageComputation accenture=new EmpWageComputation(20,20,100);
		int totalEmpWageBridze = bridgelabz.calEmpWages();
		System.out.println("Emp Wage for bridgelab:"+totalEmpWageBridze);
		
		int totalEmpWageCap = capgemini.calEmpWages();
		System.out.println("Emp wage for capgemini:"+totalEmpWageCap);

		int totalEmpWageAcc=accenture.calEmpWages();
		System.out.println("Emp wage for capgemini:"+totalEmpWageAcc);
	}
}