package com.haywire_gaming.mid_eco;

import java.util.ArrayList;

public class Validation {

	public boolean isCoupleFertile(Serf mother, Serf father) {
		if (!(mother.getSex().equals(father.getSex()))) {
			if (mother.isFertile() && father.isFertile()) {
				return true;
			}
		}
		// Couple is infertile.
		return false;
	}

	public boolean isCoupleInbreeding(Serf mother, Serf father) {

		final ArrayList<Serf> motherFamily = new ArrayList<Serf>();
		final ArrayList<Serf> fatherFamily = new ArrayList<Serf>();

		motherFamily.addAll(mother.getParents());
		motherFamily.addAll(mother.getSiblings());

		fatherFamily.addAll(father.getParents());
		fatherFamily.addAll(father.getSiblings());

		for (int i = 0; i < fatherFamily.size(); i++) {
			if (motherFamily.contains(fatherFamily.get(i))) {
				// Incest.
				return true;
			}
		}
		// Not incest.
		return false;
	}
}
