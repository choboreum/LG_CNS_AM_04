/** Quiz)
 * 입장인원이 있고
 * 버튼의 클릭 이벤트 => 인원증가
 * 해당 인원이 꽉차면 입장 버튼을 비활성화
 * 감소 버튼 클릭 이벤트 => 인원 감소
 * 입장 버튼을 활성화
 * ===================================
 * statet 상태를 관리 할 예정(증가버튼 클릭 시 입장 인원을 화면에 출력)
 */

import { useState, useEffect } from "react";
import Button from "../../component/ui/Button";

const CapacityPage = () => {
    const capacity = 5;
    //let cnt = 0;
    const [cnt, setCnt] = useState(0);
    const [full, setFull] = useState(false);
    const [empty, setEmpty] = useState(false);

    const upHandler = () => {
        console.log('>>>> upHandler call');
        
        if(cnt < 10) setCnt(cnt => cnt + 1); //함수가 함수를 인자로 받음, 람다식으로 사용(일반식은 안됨)

        console.log('<<<< upHandler', cnt);
    }
    
    const downHandler = () => {
        console.log('>>>> downHandler call');
        if(cnt <= 0){

        } else {
            setCnt(cnt => --cnt);
        }
        console.log('<<<< downHandler', cnt);
    }
    
    useEffect(() => {
        console.log('useEffect', cnt);
        setFull(cnt >= capacity);
        setEmpty(cnt <= 0);
    }, [cnt])
    
    // template ui
    return(
        <>
            <p>입장인원 : {cnt}</p>
            <Button title="입장" onClick={() => upHandler()} disabled={full} />
            <Button title="퇴장" onClick={() => downHandler()} disabled={empty} />
            {
                full && <p style={{color : 'red'}}>정원이 가득 찼습니다.</p> // && 앞 구문이 true일 경우 뒷 구문이 실행 됨 
            }
        </>
    )
}

export default CapacityPage;