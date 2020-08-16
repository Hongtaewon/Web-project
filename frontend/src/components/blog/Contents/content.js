import React from 'react';
import styles from './content.scss';
import classNames from 'classnames/bind';
import {Category,ArticleList} from 'components/blog'
const cx = classNames.bind(styles);


const content = () => {

    return (
        <div className={cx('container')}>
            <div className={cx('navside')}>
                <Category />
            </div>
            <div className={cx('contents')}>
                <div className="articleList">
                    <ArticleList />
                </div>
            </div>
        </div>
    );
};

export default content;