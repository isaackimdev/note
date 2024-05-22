/*
Failed to compile

This is because Next.js uses React Server Components,
a new feature that allows React to render on the server.

Server Components don't support useState,
so you'll need to use a Client Component instead.


A new file called layout.js was automatically created inside the app folder.
This is the main layout of your application.
You can use it to add UI elements that are shared across all pages (e.g. navigation, footer, etc).


  ※ Next에서 useState는 Server Component에서는 실행되지 않는다.
  Next에서는 기본적으로 Server Component로 사용하게 되어 있다.

*/

import { useState } from 'react';
 
function Header({ title }) {
  return <h1>{title ? title : 'Default title'}</h1>;
}
 
export default function HomePage() {
    const names = ['Ada Lovelace', 'Grace Hopper', 'Margaret Hamilton'];
 
    const [likes, setLikes] = useState(0);
   
    function handleClick() {
      setLikes(likes + 1);
    }
   
    return (
      <div>
        <Header title="Develop. Preview. Ship." />
        <ul>
          {names.map((name) => (
            <li key={name}>{name}</li>
          ))}
        </ul>
   
        <button onClick={handleClick}>Like ({likes})</button>
      </div>
    );
}