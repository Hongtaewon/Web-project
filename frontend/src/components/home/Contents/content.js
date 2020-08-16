import React from 'react';
import styles from './content.scss';
import classNames from 'classnames/bind';
import {Sidenav,Search,Recent,Category,Article} from 'components/home'
const cx = classNames.bind(styles);


const content = () => {

    return (
        <div className={cx('container')}>
            <div className={cx('navside')}>
                <Sidenav />
            </div>
            <div className={cx('contents')}>
                <div className="search">
                    <Search />
                </div>
                <div className="article">
                    <Article />
                </div>
                <div className="category">
                    <Category />
                </div>
                <div className="recent">
                    <Recent />
                </div>
            </div>
        </div>
    );
};

export default content;