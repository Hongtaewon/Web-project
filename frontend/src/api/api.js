import axios from "axios";

const API_URL = "";

export const getPost = (postId) => axios.get(`/blog/blog-post/${postId}`);
export const getPosts = (page,size) => axios.get(`/blog/blog-post?page={${page}&size=${size}}`);
export const writePost = (APIMessage) => axios.post(`/blog/blog-post`, {APIMessage});