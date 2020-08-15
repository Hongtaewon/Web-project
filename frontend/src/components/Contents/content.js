import React from 'react';
import styles from './content.scss';
import classNames from 'classnames/bind';

const cx = classNames.bind(styles);


const content = () => {

    return (
        <div className={cx('container')}>
            <div className={cx('navside')}>
                sidenav 적용
            </div>
            <div className={cx('contents')}>
                <div className="intro">
                    검색 + 소개글
                </div>
                <div className="recent">
                    최근 업로드된 글 + 이미지
                </div>
                <div className="category">
                    카테고리
                </div>
                <div className="recommand">
                    추천 기사 또는 조회수 높은 글
                </div>
            </div>
        </div>
    );
};

export default content;