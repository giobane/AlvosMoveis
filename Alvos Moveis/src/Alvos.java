
public class Alvos extends Thread{
	private long id;
	private static long l=0;
	private Posicao posin;
	private Posicao posfin;
	private Posicao posatt;
	private long timestamp;
	private long freqatt;
	private boolean chegou=false;
	private boolean atingido=false;
	private boolean mirado=false;
	
	public Alvos (Posicao posin, Posicao posfin) {
		this.id=Alvos.l;
		Alvos.l++;
		this.posin=posin;
		this.posfin=posfin;
		this.posatt=posin;
		this.freqatt=30;
		this.timestamp=System.currentTimeMillis();
		start();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Posicao getPosin() {
		return posin;
	}

	public void setPosin(Posicao posin) {
		this.posin = posin;
	}

	public Posicao getPosfin() {
		return posfin;
	}

	public void setPosfin(Posicao posfin) {
		this.posfin = posfin;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public long getFreqatt() {
		return freqatt;
	}

	public void setFreqatt(long freqatt) {
		this.freqatt = freqatt;
	}

	public boolean isMirado() {
		return mirado;
	}

	public void setMirado(boolean mirado) {
		this.mirado = mirado;
	}

	public Posicao getPosatt() {
		return posatt;
	}

	public void setPosatt(Posicao posatt) {
		this.posatt = posatt;
	}

	public boolean isChegou() {
		return chegou;
	}

	public void setChegou(boolean chegou) {
		this.chegou = chegou;
	}

	public boolean isAtingido() {
		return atingido;
	}

	public void setAtingido(boolean atingido) {
		this.atingido = atingido;
	}
	
	public void moveralvo() {
		if (this.posatt.getY()>=600) {
			this.chegou=true;
		}
		else {
			this.posatt.setY(this.posatt.getY() + 5);
		}
			
	}
	public void run() {
		while(true) {
			
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			moveralvo();
			if(isAtingido() || isChegou()) {
				break;
			}
		}
		
		
	}
	
}
