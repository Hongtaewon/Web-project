import React, { useState } from 'react';
import {Link} from 'react-router-dom';
import { Button } from 'react-bootstrap';

const Sidenav = () => {

    const [text, setText] = useState('');

    const FindBlog = () => {
        // text를 서버로 보내고 블로그 찾는 페이지로 이동
    }
    const Onchange = (e) => {
        setText(e.target.value);
    };

    return (
        <div className="container">
            <div className="sidenav">
                <h2>Web_Project Blog</h2>
                <Link to="/about">소개글</Link>
                <p>
                    <input 
                    placeholder="검색할 키워드를 입력하세요."
                    onChange={Onchange}
                    value={text}
                    />
                    <Button
                        variant="primary"
                        onClick={FindBlog}
                    >
                        검색
                    </Button>

                </p>
            </div>
        </div>
    );
};

export default Sidenav;