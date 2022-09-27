package com.ipartek.formacion.mf0967.uf2216.poo.pojos;

import com.ipartek.formacion.mf0967.uf2216.poo.presentacion.ObjetoDeporte;

public class Balon extends ObjetoDeporte implements Rodable {

	@Override
	public void rodar() {
		System.out.println("Balón rodando");
	}
}
