package Arvores;

import java.util.ArrayList;
import java.util.List;

public class ArvoreN {
	private ArvoreN[] filhos;
	private String inf;
	private int nivel;
	private int n;
	private int numeroDeFilhos;
	public int getNumeroDeFilhos(){
		return numeroDeFilhos;
	}
	public boolean inserir(ArvoreN no){
		if(numeroDeFilhos<n){
			filhos[numeroDeFilhos] = no;
			numeroDeFilhos++;
			return true;
		}else{
			for(int i=0; i<numeroDeFilhos ; i++){
				if(filhos[i].getNumeroDeFilhos()<n){
					filhos[i].inserir(no);
					return true;
				}
			}
		}
		return false;
	}
	
	public ArvoreN(String inf, int n){
		this.inf = inf;
		this.n = n;
		this.numeroDeFilhos = 0;
		this.filhos = new ArvoreN[n];
	}

	public ArvoreN[] getFilhos() {
		return filhos;
	}
	public ArvoreN getFilhos(int i) {
		return filhos[i];
	}
	public void setFilhos(ArvoreN[] filhos) {
		this.filhos = filhos;
	}

	public String getInf() {
		return inf;
	}

	public void setInf(String inf) {
		this.inf = inf;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
