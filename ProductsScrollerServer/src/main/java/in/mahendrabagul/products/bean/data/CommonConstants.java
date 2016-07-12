package in.mahendrabagul.products.bean.data;

public enum CommonConstants
{
	MAX_RECORDS(15);

	private int entityTimeLockOut;

	private CommonConstants(int entityTimeLockOut)
	{
		this.entityTimeLockOut = entityTimeLockOut;
	}

	public int getEntityTimeLockOut()
	{
		return this.entityTimeLockOut;
	}

	public void setEntityTimeLockOut(int entityTimeLockOut)
	{
		this.entityTimeLockOut = entityTimeLockOut;
	}

	public String toString()
	{
		return String.valueOf(this.entityTimeLockOut);
	}
}
