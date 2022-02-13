simple way to show native ad :

xml file :

 <RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="70sp"
    android:id="@+id/native_holder"
    ></RelativeLayout>

===================================================

in onCreate :

    private List<NativeAd> nativeAds = new ArrayList<>();
    Appodeal.setTesting(true);
    Appodeal.setAutoCache(Appodeal.NATIVE, false);
    Appodeal.initialize(this, "apikey",  Appodeal.NATIVE , true);
    setNaitivAD();

===================================================

and use this method :

private void setNaitivAD(){

    Appodeal.cache(this, Appodeal.NATIVE);
    Appodeal.setNativeCallbacks(new NativeCallbacks() {
        @Override
        public void onNativeLoaded() {
            Toast.makeText(MainActivity.this, "onNativeLoaded!", Toast.LENGTH_SHORT).show();

            nativeAds = Appodeal.getNativeAds(1);
            RelativeLayout holder = (RelativeLayout) findViewById(R.id.native_holder);
            NativeAdViewAppWall nativeAdView = new NativeAdViewAppWall(MainActivity.this, nativeAds.get(0));
            holder.addView(nativeAdView);
        }

        @Override
        public void onNativeFailedToLoad() {
            Toast.makeText(MainActivity.this, "onNativeFailedToLoad", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNativeShown(NativeAd nativeAd) {
            Toast.makeText(MainActivity.this, "onNativeShown", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNativeShowFailed(NativeAd nativeAd) {

        }

        @Override
        public void onNativeClicked(NativeAd nativeAd) {
            Toast.makeText(MainActivity.this, "onNativeClicked", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNativeExpired() {

        }
    });

}
