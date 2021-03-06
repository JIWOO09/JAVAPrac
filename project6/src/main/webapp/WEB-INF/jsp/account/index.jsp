<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>네이버 회원가입</title>
<link rel="stylesheet" href="/static/css/naverjoin.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
<section>
<form action="./join" method="post">
<div class="join-main">
        <div class="join-logo">
            <h1>NAVER</h1>
        </div>
        <div class="join-form">
            <form>
                <div class="join-info1">
                    <div class="input-form">
                        <label for="">아이디</label>
                        <div class="inline-input">
                            <input type="text" name = "username">
                            <span class="mute">@naver.com</span>
                        </div>
                    </div>
                    <div class="input-form">
                        <label for="">비밀번호</label>
                        <div class="inline-input">
                            <input type="password" name = "password">
                            <span class="material-icons">lock</span>
                        </div>
                    </div>
                    <div class="input-form">
                        <label for="">비밀번호 재확인</label>
                        <div class="inline-input">
                            <input type="password" name = "passwordcheck">
                            <span class="material-icons">check_circle</span>
                        </div>
                    </div>
                </div>
                <div class="join-info2">
                    <div class="input-form">
                        <label for="">이름</label>
                        <div class="inline-input">
                            <input type="text" name = "name">
                        </div>
                    </div>
                    <div class="input-form">
                        <label for="">생년월일</label>
                        <div class="multi-input-form">
                            <div class="input-3">
                                <input type="text" name = "year" placeholder="년(4자)" >
                            </div>
                            <div class="input-3">
                                <select name = "month">
                                    <option value="">월</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                            </div>
                            <div class="input-3">
                                <input type="text"  name = "day" placeholder="일">
                            </div>
                        </div>
                    </div>
                    <div class="input-form">
                        <label for="">성별</label>
                        <div class="inline-input">
                            <select name = "gender">
                                <option value="">성별</option>
                                <option value="남자">남자</option>
                                <option value="여자">여자</option>
                            </select>
                        </div>
                    </div>
                    <div class="input-form">
                        <label for="">본인 확인 이메일<span class="mute"><small>(선택)</small></span></label>
                        <div class="inline-input">
                            <input type="text" name = "email" placeholder="선택입력" >
                        </div>
                    </div>
                </div>
                <div class="join-info3">
                    <div class="input-form">
                        <label for="">휴대전화</label>
                        <div class="inline-input">
                            <select name = "phone_code" >
                                <option value="">대한민국 +82</option>
                            </select>
                        </div>
                        <div class="inline-input-button">
                            <div class="inline-input">
                                <input type="text" name = "phone_number" placeholder="전화번호 입력" >
                            </div>
                            <button type="button">인증번호 받기</button>
                        </div>
                        <div class="inline-input no-active">
                            <input type="text" name = "auth_num" placeholder="인증번호 입력하세요">
                        </div>
                    </div>
                </div>
                <div class="join-submit">
                    <button type="submit">가입하기</button>
                </div>
            </form>
        </div>
        <div class="join-foot">
            <div>
                이용약관 | 개인정보처리방침 | 책임의 한계와 법적고지 | 회원정보 고객센터
            </div>
            <div>
                © NAVER Corp.
            </div>
        </div>
    </div>
    </form>
    </section>
</body>
</html>