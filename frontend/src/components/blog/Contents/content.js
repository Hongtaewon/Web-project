import React from 'react';
import styles from './content.scss';
import classNames from 'classnames/bind';
import {Category,ArticleList} from 'components/blog';

import {Button} from '@material-ui/core';
const cx = classNames.bind(styles);


const content = () => {

    return (
        <div className={cx('container')}>
            <div className={cx('navside')}>
                <Category />
            </div>
            <div className={cx('contents')}>
                <Button variant="contained" color="primary" href="./1/postwrite">
                    글쓰기
                </Button>
                <div className="articleList">
                    <ArticleList />
                </div>
            </div>
        </div>
    );
};

export default content;