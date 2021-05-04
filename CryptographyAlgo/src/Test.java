import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.NamedParameterSpec;
import java.security.spec.XECPublicKeySpec;

import javax.crypto.KeyAgreement;

public class Test {
	public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, IllegalStateException, InvalidAlgorithmParameterException {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("XDH");
		NamedParameterSpec paramSpec = new NamedParameterSpec("X25519");
		kpg.initialize(paramSpec); // equivalent to kpg.initialize(255)
		// alternatively: kpg = KeyPairGenerator.getInstance("X25519")
		KeyPair kp = kpg.generateKeyPair();

		KeyFactory kf = KeyFactory.getInstance("XDH");
		 byte[] bytes = new byte[] { 0x1, 0x00, 0x00 }; // 65536
		 BigInteger u = new BigInteger(bytes);
		
		XECPublicKeySpec pubSpec = new XECPublicKeySpec(paramSpec, u);
		PublicKey pubKey = kf.generatePublic(pubSpec);
		

		KeyAgreement ka = KeyAgreement.getInstance("XDH");
		ka.init(kp.getPrivate());
		ka.doPhase(pubKey, true);
		byte[] secret = ka.generateSecret();
	}

}
