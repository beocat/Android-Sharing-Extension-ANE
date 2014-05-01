Android-Sharing-Extension-ANE
=============================

Warning! This is not procudtion ready right now. If you want to use it for twitter sharing on android, you are welcome to contact me.

Share on twitter
------------------
Based on illuzors great ane for sharing on android, I have set out to make it possible to limit the apps to use for sharing.
Right now it forces to use one, if any of the installed twitter clients. This only works for textsharing.

Original text from https://github.com/illuzor/Android-Sharing-Extension-ANE
--------
Native Extension for Adobe AIR

Features:

	- share text
	- share image
	
Important! Be shure, that you are using latest version of AIR SDK. This ANE builded for 4.0
	
How to use:

Connect com.illuzor.extensions.SharingExtension.ane file to your android air project.
Import com.illuzor.sharingextension.SharingExtension;

1) Share text:

	SharingExtension.shareText("Title", "Text for sharing");
	
2) Share image:
	
	var bitmap:Bitmap = ...;
	
	// encoding image by native encoder (FP 11.3/AIR 3.3 or newer)
	var bitmapBytes:ByteArray = bitmap.bitmapData.encode(new Rectangle(0, 0, bitmap.width, bitmap.height), new JPEGEncoderOptions(70)));
	
	var file:File = File.documentsDirectory.resolvePath("image_for_share.jpg");
	
	var stream:FileStream = new FileStream(); // write file to local memory
	stream.open(file, FileMode.WRITE);
	stream.writeBytes(fileBytes);
	stream.close();
	
	SharingExtension.shareImage(file, "Choser title", "Message"));
	
3) Dispose. If you don`t need extension after use, dispose it:

	SharingExtension.dispose();
	
Demo app - http://yadi.sk/d/Se_LR8fm1lgsD

![demoAppQR.gif](http://download.illuzor.com/images/github/ane/demoAppQR.gif)
