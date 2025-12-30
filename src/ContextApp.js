import React, { useState } from 'react'
import ContextPage from './page/context/ContextPage';
import ctx from './component/util/Context'

const ContextApp = () => {
    const [isMode, setIsMode] = useState(false);
    return (
        <div>
            <ctx.Provider value={{isMode, setIsMode}}>
                <ContextPage />
            </ctx.Provider>
        </div>
    )
}

export default ContextApp