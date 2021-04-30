echo %time%
java -Xshare:on -Xlog:class+path=info -XX:+UnlockCommercialFeatures -XX:+UseAppCDS -XX:SharedArchiveFile=ShoppingCart.jsa -cp .MyShoppingcart.jar -jar MyShoppingcart.jar
echo %time%