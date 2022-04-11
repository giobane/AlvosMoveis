
public class Tiro extends Thread {
	private int id;
	private Posicao posin;
	private Posicao posfin;
	private Posicao posatt;
	private long timestamp;
	private long freqatt;
	private boolean contato=false;
	private Posicao tirofin;
	
	public Tiro() {
		this.posin=new Posicao(300, 560);
		this.posatt=posin;
		this.timestamp=System.currentTimeMillis();
		this.freqatt=30;
	}
	
	
	public int getIdd() {
		return id;
	}

	public void setId(int id) {
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

	public Posicao getPosatt() {
		return posatt;
	}

	public void setPosatt(Posicao posatt) {
		this.posatt = posatt;
	}

	public long getFreqatt() {
		return freqatt;
	}

	public void setFreqatt(long freqatt) {
		this.freqatt = freqatt;
	}

	public boolean isContato() {
		return contato;
	}

	public void setContato(boolean contato) {
		this.contato = contato;
	}
	public long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	


	public void trajeto(Posicao tirofin) {
		long catetox=150;
		long catetoy=tirofin.getY();
		double ang=Math.atan(catetoy/catetox);
		long movex=(long) ((Math.cos(ang))*5);
		long movey=(long) ((Math.sin(ang))*5);
		if (tirofin.getX()<300) {
			getPosatt().setX((int) (getPosatt().getX() - movex));
			getPosatt().setY((int) (getPosatt().getY() - movey));
		}
		else {
			getPosatt().setX((int) (getPosatt().getX() + movex));
			getPosatt().setY((int) (getPosatt().getY() - movey));
		}
	}
	
	public void run() {
		while(true) {
			trajeto(tirofin);
			if(isContato()) {
				break;
			}
			try {
				Thread.sleep(getFreqatt());
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			}
		}
		
		
	}


	public Posicao getTirofin() {
		return tirofin;
	}


	public void setTirofin(Posicao tirofin) {
		this.tirofin = tirofin;
	}


	
}












