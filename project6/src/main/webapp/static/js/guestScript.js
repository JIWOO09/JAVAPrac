function guestModify(element) {
    var tr = element.parentElement;
    
    // 1. 테이블의 번호에 해당하는 값을 input 태그의 값으로 설정
    var id = tr.children[0];
    var id_input = document.createElement("input");
    id_input.type = "hidden";
    id_input.value = id.innerText;
    id_input.name = "id";
    id_input.setAttribute("form", "modify_form");
    id.append(id_input);
    
    // 2. 테이블의 내용에 해당하는 값을 textarea 태그의 값으로 설정
    var context = tr.children[2];
    var context_area = document.createElement("textarea");
    context_area.value = context.innerText;
    context.innerText = "";
    context_area.name = "context";
    context_area.setAttribute("form", "modify_form");
    context.append(context_area);
    
    // 3. 확인 버튼을 눌렀을 때 서버에 전송이 가능하도록 form 태그도 생성
    var form = document.createElement("form");
    form.id = "modify_form";
    form.action = "./guest";
    form.method = "post";
    element.append(form);
    
    // 4. 수정 버튼은 확인 버튼으로 변경
    var btn_modify = element.children[0];
    btn_modify.innerText = "확인";
    btn_modify.onclick = function() {
        document.getElementById("modify_form").submit();
    }
    
    // 5. 삭제 버튼은 취소 버튼으로 변경
    var btn_delete = element.children[1];
    btn_delete.innerText = "취소";
    btn_delete.onclick = function() {};
    
    // 6. 취소 버튼을 눌렀을 때 입력 폼들이 원래의 상태로 돌아 가도록 재 구성
}
