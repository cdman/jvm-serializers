package serializers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerOutputStream;
import com.turkcelltech.jac.OctetString;

import data.media.Image;
import data.media.Media;
import data.media.MediaContent;

public final class Asn1 {
	public static void register(TestGroups groups) {
		groups.media.add(
				new Transformer<MediaContent, serializers.asn1.MediaContent>() {
					@Override
					public serializers.asn1.MediaContent forward(MediaContent a) {
						serializers.asn1.MediaContent result = new serializers.asn1.MediaContent();
						copy(a, result);
						return result;
					}

					@Override
					public MediaContent reverse(serializers.asn1.MediaContent a) {
						MediaContent result = new MediaContent();
						copy(a, result);
						return result;
					}

					@Override
					public MediaContent shallowReverse(
							serializers.asn1.MediaContent a) {
						Media media = new Media();
						copy(a.media, media);
						return new MediaContent(media, Collections
								.<Image> emptyList());
					}

					private void copy(serializers.asn1.Media media1,
							Media media2) {
						media2.uri = new String(media1.uri.getValue());
						media2.title = new String(media1.title.getValue());
						media2.width = (int) media1.width.getValue();
						media2.height = (int) media1.height.getValue();
						media2.format = new String(media1.format.getValue());
						media2.duration = (int) media1.duration.getValue();
						media2.size = (int) media1.size.getValue();
						media2.bitrate = (int) media1.bitrate.getValue();
						media2.hasBitrate = media1.hasBitrate.getValue();
						media2.persons = new ArrayList<>();
						for (Object obj : media1.persons.getList()) {
							String person = new String(
									((com.chaosinmotion.asn1.BerOctetString) obj)
											.getValue());
							media2.persons.add(person);
						}
						media2.player = Media.Player.values()[(int) media1.player
								.getValue()];
						if (media1.copyright.getValue() != null) {
							media2.copyright = new String(media1.copyright
									.getValue());
						}
					}

					private void copy(MediaContent mc1,
							serializers.asn1.MediaContent mc2) {
						copy(mc1.media, mc2.media);
						for (Image image1 : mc1.images) {
							serializers.asn1.Image image2 = new serializers.asn1.Image();
							copy(image1, image2);
							mc2.images.addElement(image2);
						}
						mc2.isInitialized = true;
					}

					private void copy(serializers.asn1.MediaContent media1,
							MediaContent media2) {
						media2.media = new Media();
						copy(media1.media, media2.media);
						media2.images = new ArrayList<>();
						for (Object obj : media1.images.getList()) {
							serializers.asn1.Image image1 = (serializers.asn1.Image) obj;
							Image image2 = new Image();
							copy(image1, image2);
							media2.images.add(image2);
						}
					}

					private void copy(serializers.asn1.Image image1,
							Image image2) {
						image2.uri = new String(image1.uri.getValue());
						image2.title = new String(image1.title.getValue());
						image2.width = (int) image1.width.getValue();
						image2.height = (int) image1.height.getValue();
						image2.size = Image.Size.values()[(int) image1.size
								.getValue()];
					}

					private void copy(Image image1,
							serializers.asn1.Image image2) {
						image2.uri.setValue(image1.uri.getBytes());
						image2.title.setValue(image1.title.getBytes());
						image2.width.setValue(image1.width);
						image2.height.setValue(image1.height);
						image2.size.setValue(image1.size.ordinal());
						image2.isInitialized = true;
					}

					private void copy(Media media1,
							serializers.asn1.Media media2) {
						media2.uri.setValue(media1.uri.getBytes());
						media2.title.setValue(media1.title.getBytes());
						media2.width.setValue(media1.width);
						media2.height.setValue(media1.height);
						media2.format.setValue(media1.format.getBytes());
						media2.duration.setValue(media1.duration);
						media2.size.setValue(media1.size);
						media2.bitrate.setValue(media1.bitrate);
						media2.hasBitrate.setValue(media1.hasBitrate);
						media2.player.setValue(media1.player.ordinal());
						if (media1.copyright != null) {
							media2.copyright.setValue(media1.copyright
									.getBytes());
						}
						for (String person1 : media1.persons) {
							OctetString person2 = new OctetString();
							person2.setValue(person1.getBytes());
							media2.persons.addElement(person2);
						}
						media2.isInitialized = true;
					}

					@Override
					public MediaContent[] sourceArray(int size) {
						return new MediaContent[size];
					}

					@Override
					public serializers.asn1.MediaContent[] resultArray(int size) {
						return new serializers.asn1.MediaContent[size];
					}
				}, new Serializer<serializers.asn1.MediaContent>() {
					private final ResetableByteArrayOutputStream bOut = new ResetableByteArrayOutputStream();
					private final BerOutputStream berOut = new BerOutputStream(
							bOut);
					private final ResetableByteArrayInputStream bIn = new ResetableByteArrayInputStream();
					private final BerInputStream berIn = new BerInputStream(bIn);

					@Override
					public serializers.asn1.MediaContent deserialize(
							byte[] array) throws Exception {
						bIn.setBuffer(array);
						serializers.asn1.MediaContent result = new serializers.asn1.MediaContent();
						result.decode(berIn);
						return result;
					}

					@Override
					public byte[] serialize(
							serializers.asn1.MediaContent content)
							throws Exception {
						content.encode(berOut);
						byte[] result = bOut.toByteArray();
						bOut.clear();
						return result;
					}

					@Override
					public String getName() {
						return "asn1";
					}
				});
	}

	private static final class ResetableByteArrayInputStream extends
			ByteArrayInputStream {
		ResetableByteArrayInputStream() {
			super(new byte[0]);
		}

		void setBuffer(byte[] buffer) {
			this.buf = buffer;
			this.pos = 0;
			this.count = buffer.length;
		}
	}

	private static final class ResetableByteArrayOutputStream extends
			ByteArrayOutputStream {
		void clear() {
			this.count = 0;
		}
	}
}
