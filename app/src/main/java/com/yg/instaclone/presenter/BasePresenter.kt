package com.yg.instaclone.presenter



open class BasePresenter<T> {
    //프레젠터 : 뷰에 넣을 값들을 생성해냄. + 뷰, 모델간 데이터 전달
    //모델 : 프레젠터가 준 값을 토대로 뷰에 반환할 값 프레젠터에게 전달.
    //뷰 : 말 그대로 뷰, 사용자가 입력한(or 시스템의) 이벤트를 토대로 프레젠터에게 역할 요청.

    var view : T? = null
    //T는 nullable
}